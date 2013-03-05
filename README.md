# scala-base62

Base62 encoder/decoder for Scala

```scala
scala> val base62 = new Base62
base62: com.github.tototoshi.base62.Base62 = com.github.tototoshi.base62.Base62@336215d4

scala> base62.encode(12345)
res0: String = 3D7

scala> base62.decode("3D7")
res1: Long = 12345
```

