### 上传下载

文件上传:
servlet版:
客户端：\<form method="post" enctype="multipart/form-data">
Servlet:
完成上传工作的是第三方插件：smartupload \commons-fileupload构造第三方插件,将request交给组件解析，从组件中获得相应的参数

Struts版:
客户端:\<form method="post" enctype="multipart/form-data">
Action:
完成上传工作的还是第三方组件:commons-fileupload
struts 中提供 文件上传拦截器 struts-default 负责从第三方组件中获得文件信息给Action中的相应属性赋值。
我们在Action中直接可以获得文件对象。 File
```java
private File pic;
private String picFileName;
private String picContentType;//mime jpg image/jpeg text/html
  InputStream is = new FileInputStream(pic);

  ServletContext application = ServletActionContext.
    getServletContext();
  //d:\tomcat\webapps\struts_upload\myfiles\xxxx.jpg
  String path = application.
      getRealPath("/myfiles/"+picFileName);
    OutputStream os = new FileOutputStream(path);

    int length;
  byte[] data = new byte[1024<<3];
  while((length=is.read(data))!=-1){
    os.write(data,0,length);
```
文件下载
```java
ServletContext application = ServletActionContext.getServletContext();
HttpServletResponse response = ServletActionContext.getResponse();
String path = application.getRealPath("/myfiles/"+filename);
InputStream is = new FileInputStream(path);
response.setHeader("Content-Disposition","attachment;filename=001.jpg");
OutputStream os = response.getOutputStream();
int length;
byte[] data = new byte[1024<<3];
while((length=is.read(data))!=-1){
  os.write(data,0,length);
}
```
文件下载
```java
private InputStream is;
public InputStream getIs(){return is;}

public String down(){
  ServletContext application = ServletActionContext.
      getServletContext();
  String path = application.getRealPath("/myfiles/"+filename);
   is = new FileInputStream(path);
   filename=URLEncoder.encode("中文","UTF-8")+"aaa.jpg";
```

### json
struts-json:
1.
```java
response.getWriter()
out.print(ja jo "{\"flag\":\"success\"}");
```

2.
封装一个getter方法
```xml
<result type="json" name="success">
  <!-- 将stus属性组装成JSON 返回  -->
  <param name="root">stus</param>
  <!-- {pre,next:xx,rows:[{id,name:xx,category:{id:xx ,name:xx,books:[]},bookpics:[]},{}]} -->
  <param name="root">page</param>
  <param name="excludeProperties">
    rows\[\d+\]\.bookpics,
    rows\[\d+\]\.category\.books
  </param>
</result>
```
