# Navigation

Sub-sections:
- [Basic](src/main/java/com/github/mrbean355/android/navigation/basic)
- [Bottom Nav](src/main/java/com/github/mrbean355/android/navigation/bottomnav)
- [Nav Drawer](src/main/java/com/github/mrbean355/android/navigation/navdrawer)

My YouTube videos:
- [Basic walkthrough](https://www.youtu.be/MtcRVVygP_g)
- [Setting up with bottom nav](https://youtu.be/ZAXvoRjdZuM)
- [Setting up with nav drawer](https://youtu.be/wv5VFEcnb-8)

[Official documentation](https://developer.android.com/guide/navigation)

## Latest Versions

When adding the required dependencies, it's highly recommended to check [maven.google.com](http://maven.google.com) for the latest versions.

## Java Code

Here is the equivalent Java code of the Kotlin code seen in this project:

| Description                              | Kotlin                                                 | Java                                                                                                    |
|:-----------------------------------------|:-------------------------------------------------------|:--------------------------------------------------------------------------------------------------------|
| Finding `NavController` in an `Activity` | `findNavController(R.id.nav_host_fragment)`            | `Navigation.findNavController(this, R.id.nav_host_fragment)`                                            |
| Finding `NavController` in a `Fragment`  | `findNavController()`                                  | `NavHostFragment.findNavController(this)`                                                               |
| Setting up the action bar                | `setupActionBarWithNavController(navController)`       | `NavigationUI.setupActionBarWithNavController(this, navController)`                                     |
| Loading `Fragment` arguments             | `private val args: PayPersonFragmentArgs by navArgs()` | `PayPersonFragmentArgs args = PayPersonFragmentArgs.fromBundle(getArguments());` (in `onViewCreated()`) |
