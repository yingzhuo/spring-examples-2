# ----------------------------------------------------------------------------------------------------------------------
# 预构建阶段
# ----------------------------------------------------------------------------------------------------------------------
FROM registry.cn-shanghai.aliyuncs.com/yingzhuo/springboot:8 AS builder

# 拷贝Jar
COPY *.jar app.jar

# 解压缩Jar并删除无用依赖和无用文件
RUN java -Djarmode=layertools -jar /opt/app.jar extract && \
    rm -rf /opt/dependencies/BOOT-INF/lib/spring-boot-jarmode-layertools-*.jar && \
    rm -rf /opt/application/BOOT-INF/classpath.idx && \
    rm -rf /opt/application/BOOT-INF/layers.idx

# ----------------------------------------------------------------------------------------------------------------------
# 实际构建阶段
# ----------------------------------------------------------------------------------------------------------------------
FROM registry.cn-shanghai.aliyuncs.com/yingzhuo/springboot:8

LABEL maintainer="应卓 <yingzhor@gmail.com>"

# 分层拷贝
COPY --from=builder /opt/dependencies/ ./
COPY --from=builder /opt/spring-boot-loader/ ./
COPY --from=builder /opt/snapshot-dependencies/ ./
COPY --from=builder /opt/application/ ./

# 预设环境变量
ENV APP_PROFILES=k8s

# 暴露端口 (Optional)
EXPOSE 8080