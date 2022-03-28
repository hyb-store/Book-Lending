> [推荐算法-协同过滤算法](https://github.com/hyb-store/mahout)
>
> [OCR文字识别](https://github.com/hyb-store/ocr)


















#### pagehelper
```yaml
pagehelper:
  #指定数据库，不指定的话会默认自动检测数据库类型
  helper-dialect: mysql  
  #是否启用分页合理化。如果启用，当pagenum<1时，会自动查询第一页的数据，当pagenum>pages时，自动查询最后一页数据；不启用的，以上两种情况都会返回空数据
  reasonable: true  
  #默认值false，分页插件会从查询方法的参数值中，自动根据上面 params 配置的字段中取值，查找到合适的值时就会自动分页。
  support-methods-arguments: true 
  #为了支持startPage(Object params)方法
  #默认值为：params: pageNum=pageNum;pageSize=pageSize;count=countSql;reasonable=reasonable;pageSizeZero=pageSizeZero
  params: countSql
```