# Dubbo-Nacos-Sentinel
快速构建一个基础中台节点
## Nacos
服务治理中心
配置中心，实现配置文件热更新
### 生产化改造
配置中心的配置文件持久化--mysql
```
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_devtest?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
db.user=root
db.password=root
```
集群配置
修改cluster.conf,集群节点单数
```
ip:port
ip:port
ip:port
```
## Sentinel
生产化改造的Sentinel，DashBoard在仓库的Sentinel—Pro
### 客户端改造
查看dubbo-provider与dubbo-consumer模块
### 模块启动时添加上报信息
idea直接在VM options中添加
```
-Dcsp.sentinel.api.port=8720  //上报信息所用的端口
-Dcsp.sentinel.dashboard.server=127.0.0.1:8858 //Sentinel控制台地址与端口
-Dproject.name=dubbo-provider //在控制台显示的名字
```

## Gateway
使用SpringCloud-GateWay
实现请求路由转发，与Sentinel整合实现网关流控，与Nacos整合实现路由配置，网关流控配置云存储

## Skywalking(自行添加即可)
分布式系统，全链路跟踪。
### 快速启动：
#### 1、使用docker 启动：
elasticsearch--用于数据收集
skywalking-oap-server--服务器
skywalking-ui--控制台
#### 2、添加启动参数
idea直接在VM options中添加
```
-javaagent:D:\apache-skywalking-apm-bin\agent\skywalking-agent.jar //探针地址，官方项目下可下载
-Dskywalking.agent.service_name=dubbo-nacos-classifier  //控制台显示的名字
-Dskywalking.collector.backend_service=192.168.1.126:11800 //服务器地址与端口
```
## Nacos配置中心配置实例
### 网关路由配置
```
[
   {
        "id": "1",
        "predicates":[
            {
                "args": {
                    "pattern": "/1"
                },
                "name": "Path"
            }
        ],
        "uri": "http://127.0.0.1:18082"
    }
]
```
### 网关流控规则配置
```
[
    {
        "resource": "1",
        "limitApp": "default",
        "grade": 1,
        "count": 1,
        "strategy": 0,
        "controlBehavior": 0,
        "clusterMode": false
    }
]
```
### Sentinel资源流控配置
```
[
    {
        "resource": "com.ziyoo.dubboapi.defaultservices.DefaultServices:sayHello()",
        "limitApp": "default",
        "grade": 1,
        "count": 5,
        "strategy": 0,
        "controlBehavior": 0,
        "clusterMode": false
    }
]
```







