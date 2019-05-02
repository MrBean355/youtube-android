# Dagger 2

My YouTube videos:
- [Basic walkthrough](https://youtu.be/7aYoChBBoI4)

[Official documentation](https://google.github.io/dagger/)

## Brief Explanations

- `@Module` class - "Dagger, this is *how* to create my dependencies"
- `@Component` class - "Dagger, these are my `@Module`s, please build the dependency graph"
- `@Inject` constructor - "Dagger, please use this constructor to instantiate this class"
- `@Inject` field - "Dagger, please set this field for me"
- `AndroidInjection.inject(this)` - "Dagger, please inject this class's fields now"
- `@Singleton` in a `@Module` - "Dagger, please only create one instance of this dependency" (be sure you know what your're doing when using this)
