# Build stage #
FROM maven:3.8.6-openjdk-8 AS build
COPY src /home/app/src

# Build file war
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package

# Package Stage #
FROM quay.io/wildfly/wildfly

#Tạo user linh và password linh để đăng nhập wildfly manage console page
RUN /opt/jboss/wildfly/bin/add-user.sh linh linh --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

# Đưa file war vào container
COPY target/demo-0.1.war /opt/jboss/wildfly/standalone/deployments/

USER root

# Change java version
COPY --from=build /usr/local/openjdk-8/* /usr/lib/jvm/java/

# Change file WAR ownership to jboss:jboss
RUN chown jboss:jboss /opt/jboss/wildfly/standalone/deployments/demo-0.1.war

# Chuyển về user jboss
USER jboss

# Tạo thư mục lưu file log
RUN  mkdir /opt/jboss/wildfly/standalone/log

EXPOSE 8080
