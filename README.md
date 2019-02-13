This is a sample project to reproduce a false-positive lint issue.

Steps to reproduce:

`./gradlew lintDebug`

This reproduces a lint report containing this `UnusedResources` issue:

```
Unused resources
../../src/main/res/layout/activity_main.xml:2: The resource R.layout.activity_main appears to be unused
  1 <?xml version="1.0" encoding="utf-8"?>
  2 <layout xmlns:android="http://schemas.android.com/apk/res/android"                                  
  3         xmlns:tools="http://schemas.android.com/tools"
  4         xmlns:app="http://schemas.android.com/apk/res-auto">
```

However, this layout file is indeed used:
```
MainActivity.onCreate()
  -> ActivityMainBinding.inflate(LayoutInflater)
     -> ActivityMainBinding.inflate(LayoutInflater,DataBindingComponent)
```

The generated code in `ActivityMainBinding` refers directly to this layout xml file:

```java
  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMainBinding>inflate(inflater, com.example.databindinglintissue.R.layout.activity_main, null, false, component);
  }
```

