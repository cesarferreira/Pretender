# Pretender
<p align="center">

A Library for generating random user data. Like Lorem Ipsum, but for people.
</p>
<!--<p align="center">
<img src="https://raw.github.com/cesarferreira/Pretender/master/extras/images/logo.png?raw=true" width="100%" />
</p>-->

## Usage

Simple Usage:
```java
Pretender.with(context)
         .fetch(callback);
```


Get 30 women from US:
```java
Pretender.with(context)
         .amount(30)
         .nationality(Nationality.US)
         .gender(Gender.FEMALE)
         .fetch(callback);
```


## Result Example
```json
{
  results: [{
    user: {
      gender: "female",
      name: {
        title: "ms",
        first: "manuela",
        last: "velasco"
      },
      location: {
        street: "1969 calle de alberto aguilera",
        city: "la coruña",
        state: "asturias",
        zip: "56298"
      },
      email: "manuela.velasco50@example.com",
      username: "heavybutterfly920",
      password: "enterprise",
      salt: ">egEn6YsO",
      md5: "2dd1894ea9d19bf5479992da95713a3a",
      sha1: "ba230bc400723f470b68e9609ab7d0e6cf123b59",
      sha256: "f4f52bf8c5ad7fc759d1d4156b25a4c7b3d1e2eec6c92d80e508aa0b7946d4ba",
      registered: "1303647245",
      dob: "415458547",
      phone: "994-131-106",
      cell: "626-695-164",
      DNI: "52434048-I",
      picture: {
        large: "http://api.randomuser.me/portraits/women/39.jpg",
        medium: "http://api.randomuser.me/portraits/med/women/39.jpg",
        thumbnail: "http://api.randomuser.me/portraits/thumb/women/39.jpg",
      },
      version: "0.6"
      nationality: "ES"
    },
    seed: "graywolf"
  }]
}
```


## Install

**Step 1:** Add the JitPack repository to your main `build.gradle`


```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```


**Step 2:** Add the dependency in the form
```groovy
dependencies {
    compile 'com.github.cesarferreira:pretender:0.1.0'
}
```



## Contributing

1. Fork it ( https://github.com/cesarferreira/Pretender/fork )
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create a new Pull Request
