# android-base-template
with Fragments, also ListFragment+SwipeRefresh

#### Source Structure:

* ```com.example.myapp.activities``` - Contains all activities
* ```com.example.myapp.fragments``` - Contains all fragments
* ```com.example.myapp.adapters``` - Contains all custom adapters
* ```com.example.myapp.models``` - Contains all our data models
* ```com.example.myapp.helpers``` - Contains all helpers supporting code.
* ```com.example.myapp.interfaces``` - Contains all interfaces
* ```com.example.myapp.views``` - Contains all custom views

see also [Examples](http://guides.codepath.com/android/Organizing-your-Source-Files#android-folder-structure)

#### Resources Structure with Subfolders:

* |-- ```res```
* &nbsp;&nbsp;&nbsp;&nbsp;|-- ```layouts```
* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-- ```activity```
* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|-- ```layout``` - Contains all layouts for activities
* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-- ```adapter```
* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|-- ```layout``` - Contains all layouts for adapters
* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-- ```fragment```
* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|-- ```layout``` - Contains all layouts for fragments
* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-- ```other```
* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|-- ```layout``` - Contains other layouts

And need to update ```build.gradle```:

```java
android {

    .....
    .....
    
    sourceSets {
        main {
            res.srcDirs = [
                    'src/main/res/layouts/activity',
                    'src/main/res/layouts/fragment',
                    'src/main/res/layouts/adapter',
                    'src/main/res/layouts/other'
                    ]
        }
    }
}
```

NOTE: you can add any folders to ```layouts```
