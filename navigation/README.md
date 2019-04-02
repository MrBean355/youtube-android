# Navigation Component

[My YouTube video walkthrough](https://www.youtube.com/watch?v=MtcRVVygP_g)

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
