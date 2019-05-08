---
# 归纳总结

 **static**  与 **template** 目录的作用：
    <br>
      
    以资源的 形式被加载的页面或者其他的文件都在static中，
    在controller中返回的页面，或者model中的页面路径都在
    template中
### thymeleaf
    1. 显示普通文本
        th:text
        
    2. 带有html标签的文本
        th:utext
        尽量不要用控制器中添加html样式标签
        
    3. 资源文件
        是
