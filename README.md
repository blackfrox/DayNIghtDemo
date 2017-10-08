# DayNIghtDemo

官方其实有一种设置方法要求Activity是继承AppcompatActivity才能使用，
还需要设置Theme为Theme.AppCompat.DayNight 后缀随意

不过现在基本都默认支持，所以只需要更改theme

设置夜间模式

AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

设置日间模式

AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

之后需要将activity重启，调用Activity的recreate()

demo地址  https://github.com/breakfrox/DayNIghtDemo

(PS： 具体的实现步骤。在APP.kt里，callback里的方法对应activity的生命周期，

使用Kotlin)





如果需要复杂设置的话需要准备夜间模式使用的them和icon

大致操作可以看这篇 (写了夜间模式的其他实现方法)

http://liandongyang.coding.me/post/android-support-night-mode/
