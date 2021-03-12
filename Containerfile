FROM registry.access.redhat.com/ubi8/ubi-minimal:latest
MAINTAINER Jaroslaw Stakun jstakun@redhat.com
LABEL quarkus-version=1.12.1.Final
COPY ./target/*-runner /application
RUN chgrp 0 /application && chmod 110 /application
USER 1001
CMD /application
EXPOSE 8080