FROM openjdk:8
VOLUME /tmp
ADD *.jar amap.jar
# 时区修改
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && \
    echo $TZ > /etc/timezone
ENV JAVA_OPS=-Xmx1g
ENTRYPOINT java ${JAVA_OPS} -Djava.security.egd=file:/dev/./urandom -jar /amap.jar
EXPOSE 80