# 使用thymeleaf遇到的坑：
## 1.for循环（th:each）采坑：使用th:each的时候，标签放在哪里，循环就从哪里开始
### 问题写法：
```html
<div class="carousel-inner" th:each="banner,iterStat:${bannerList}">
    <div class="carousel-item" th:classappend="${iterStat.index==0}?'active':''">
        <img th:src="${banner.img}">
    </div>
</div>
```
### 效果：
```html
<div class="carousel-inner">
    <div class="carousel-item active">
        <img src="https://s2.ax1x.com/2019/09/27/uMQaLQ.jpg">
    </div>
</div>
<div class="carousel-inner">
    <div class="carousel-item ">
        <img src="https://s2.ax1x.com/2019/09/27/uMQaLQ.jpg">
    </div>
</div>
<div class="carousel-inner">
    <div class="carousel-item ">
        <img src="https://s2.ax1x.com/2019/09/27/uMQaLQ.jpg">
    </div>
</div>
```

### 正确写法：`<div class="carousel-inner">`不应该参与循环
```html
<div class="carousel-inner">
    <div class="carousel-item" th:each="banner,iterStat:${bannerList}" th:classappend="${iterStat.index==0}?'active':''">
        <img th:src="${banner.img}">
    </div>
</div>
```
### 效果：
```html
<div class="carousel-inner">
    <div class="carousel-item active">
        <img src="https://s2.ax1x.com/2019/09/27/uMQaLQ.jpg">
    </div>
    <div class="carousel-item ">
        <img src="https://s2.ax1x.com/2019/09/27/uMQaLQ.jpg">
    </div>
    <div class="carousel-item ">
        <img src="https://s2.ax1x.com/2019/09/27/uMQaLQ.jpg">
    </div>
</div>
```

## WebMvcConfigurationSupport和WebMvcConfigurer的区别
### 1、WebMvcConfigurationSupport的出现
springboot2.0之后配置拦截器extends 的WebMvcConfigurerAdapter过时，取而代之的是WebMvcConfigurationSupport。WebMvcConfigurerAdapter只是对WebMvcCofigurer的空实现,而WebMvcConfigurationSupport的实现的方法更全面

### 2、注意点
继承WebMvcConfigurationSupport会发现Spring Boot的WebMvc自动配置失效(WebMvcAutoConfiguration自动化配置)。
导致无法视图解析器无法解析并返回到对应的视图。
