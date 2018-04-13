## 项目目录

    nkop-eureka-server  ：服务注册中心
    nkop-config-server  ：配置中心
    nkop-zuul-server    ：网关
    nkop-framework      ：开发框架
    nkop-interface      ：接口
    nkop-admin-server   ：管理应用
    
## Restful 接口规范
#### URL规范
1. 不用大写；
2. 用下杠 “_” 不用中杠 “-” ；
3. 参数列表要encode；
4. URI中的名词表示资源集合，使用复数形式。

#### 版本
应该将API的版本号放入URL。
```
https://api.example.com/v1/
```
#### 路径
在RESTful架构中，每个网址代表一种资源（resource），所以网址中不能有动词，只能有名词，而且所用的名词往往与数据库的表格名对应。一般来说，数据库中的表都是同种记录的"集合"（collection），所以API中的名词也应该使用复数。
举例来说，有一个API提供动物园（zoo）的信息，还包括各种动物和雇员的信息，则它的路径应该设计成下面这样。
```
https://api.example.com/v1/zoos
https://api.example.com/v1/employees
```
如公共接口、同时提供PC、APP接口需要做区分,/g表示公共接口，/app表示app专用接口，如系统只提供app或者pc的服务，则不需要该标签。
```
https://api.example.com/v1/zoos/g/
https://api.example.com/v1/zoos/app/
```
#### 动词
对于资源的具体操作类型，由HTTP动词表示。
常用的HTTP动词有下面五个（括号里是对应的SQL命令）。
```
GET（SELECT）：从服务器取出资源（一项或多项）。
POST（CREATE）：在服务器新建一个资源。
PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
DELETE（DELETE）：从服务器删除资源。
```
#### 示例
```
GET /zoos：列出所有动物园
POST /zoos/search：接收对象参数，列出符合条件的动物园
POST /zoos：新建一个动物园
GET /zoos/ID：获取某个指定动物园的信息
PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息）
PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）
DELETE /zoos/ID：删除某个动物园
GET /zoos/ID/animals：列出某个指定动物园的所有动物
DELETE /zoos/ID/animals/ID：删除某个指定动物园的指定动物
```
#### 过滤信息
如果记录数量很多，服务器不可能都将它们返回给用户。API应该提供参数，过滤返回结果。
```
?limit=10：指定返回记录的数量
?offset=10：指定返回记录的开始位置。
?page=2&per_page=100：指定第几页，以及每页的记录数。
?sortby=name&order=asc：指定返回结果按照哪个属性排序，以及排序顺序。
?animal_type_id=1：指定筛选条件
```
参数的设计允许存在冗余，即允许API路径和URL参数偶尔有重复。比如，GET /zoo/ID/animals 与 GET /animals?zoo_id=ID 的含义是相同的。
#### 状态码
```
200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
204 NO CONTENT - [DELETE]：用户删除数据成功。
400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。
```
#### 错误处理
```
{
    code:"NK-ERROR-000000",
    error: "Invalid API key",
    stack:"Java.lang.NullException"
}
```
#### 返回结果
针对不同操作，服务器向用户返回的结果应该符合以下规范。
```
GET /collection：返回资源对象的列表（分页）
POST /collection/search：返回资源对象的列表（分页）
GET /collection/resource：返回单个资源对象
POST /collection：返回新生成的资源对象
PUT /collection/resource：返回完整的资源对象
PATCH /collection/resource：返回完整的资源对象
DELETE /collection/resource：返回一个空文档
```
## 异常处理规范

## 日志记录规范

## 代码管理规范

## 
