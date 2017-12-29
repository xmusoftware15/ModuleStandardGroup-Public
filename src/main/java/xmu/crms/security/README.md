## Spring Security Integration Introduction

### 第一步， 复制代码结构

直接按照github上面的代码结构，把相应代码复制到自己的项目路径，包括：

```
xmu.crms.conf 包
xmu.crms.dao 下的LoginDao接口、AuthDao接口(未实现)
xmu.crms.security 包
xmu.crms.service.security 包
xmu.crms.util 包
```

### 第二步，配置SpringSecurity参数

在项目的 src/main/resources/application.properties中添加以下配置

```
# Spring Security
## 用于给jwt最后一个字段加密的密钥， 可随意自定义， 但要是base64编码（网上有在线编码工具）
jwt_secret=Ym9zcyBtaW5ncWl1
## 前端访问接口时候， request请求头的 字段名
# e.g. Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjMiLCJ0eXBlIjoidGVhY2hlciIsImV4cCI6MTUxNTA2OTc0MSwiaWF0IjoxNTE0NDY0OTQxfQ.djb2UEouZADUB01gH5oYHJ357RXKnqpFh13Z1IBDBrWS7uEjzpQunjjesf1y51QI3lMnQ8aEfLrH6EK9jxAMuQ
jwt_header = Authorization
## jwt token 开头的字符
jwt_token_head = "Bearer "

# WeChat
## 小程序的appid 
appid = your appid
## 小程序的secret
secret = your secret

## 验证失败后跳转的页面uri
failure_page = /login
```

### 第三步，配置api接口的权限

由于各组实际实现的接口可能与标准组的不太一样(偷偷地)，而且接口数量也比较多，所以我觉得采用注解的方式配置权限比较好，配置方式如下：

#### 配置语法 直接举栗子

> 权限有 老师和学生 两种 分别是 STUDENT 和 TEACHER

```
@PreAuthorize("hasRole('STUDENT')")  // 只能允许学生访问
@PreAuthorize("hasRole('TEACHER')") // 只允许老师访问
@PreAuthorize("hasRole('STUDENT') or hasRole('TEACHER')")  // 学生或老师都能访问
```

#### 放置

注解放置在拥有相应权限的api接口上面就可以了， 例如

```
	@PreAuthorize("hasRole('TEACHER')")
	@RequestMapping(value = "/seminar/{seminarId}", method = DELETE)
	public ResponseEntity deleteSeminarById(@PathVariable BigInteger seminarId) {
		try {
			seminarService.deleteSeminarBySeminarId(seminarId);
			return ResponseEntity.status(204).build();
		} catch (SeminarNotFoundException e) {
			return ResponseEntity.status(404).build();
		}
	}
```

这个例子中，接口地址是

> DELETE /seminar/{seminarId}

根据Controller标准组的标准，这个接口是用于删除seminar的，很显然只有老师可以调用，所以给予权限TEACHER

> @PreAuthorize("hasRole('TEACHER')")



### 有问题联系

mad.s@qq.com