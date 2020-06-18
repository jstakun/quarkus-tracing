FROM registry.access.redhat.com/ubi8/ubi-minimal:latest
COPY ./target/*-runner /application
RUN chgrp 0 /application && chmod +x /application
USER 1001
CMD /application
EXPOSE 8080
