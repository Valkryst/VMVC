[![Java CI with Maven](https://github.com/Valkryst/VMVC/actions/workflows/maven.yml/badge.svg)](https://github.com/Valkryst/VMVC/actions/workflows/maven.yml)
[![CodeQL](https://github.com/Valkryst/VMVC/actions/workflows/codeql.yml/badge.svg)](https://github.com/Valkryst/VMVC/actions/workflows/codeql.yml)

This project is currently under a rewrite, and is not yet ready for use.

## Example

### Controller

A `Controller` provides a way for a `Model` and `View` to communicate with each other. 

The `Controller` is responsible for updating the `Model` when the `View` changes. Depending on your application, you can
have the `Controller` implement various Listener interfaces (e.g. `ActionListener`, `ChangeListener`, etc.) if they
_only_ need to communicate with the `Model` when the `View` changes. In cases where the `View` needs to be updated,
then the Listener should be implemented within the `View` and that Listener should call functions in the `Controller`
to achieve its goal.

Functions within the `Controller` should only get or set data within the `Model` and should not directly interact with
the `View`.

```java
public class ExampleController extends Controller<ExampleModel> {
    public ExampleController(final ExampleModel model) {
        super(model);
    }
}
```

### Model

A `Model` contains all data, and logic for manipulating that data, for all of its associated `View`s.

```java
public class ExampleModel extends Model<ExampleController, ExampleView> {
  @Override
  protected ExampleController createController() {
    return new ExampleController(this);
  }

  @Override
  protected ExampleView createView(final ExampleController controller) {
    return new ExampleView(controller);
  }
}
```

### View

A `View` is a Swing UI that displays the data from its associated `Model` and allows the user to interact with that data.

```java
public class ExampleView extends View<ExampleController> {
  public ExampleView(final ExampleController controller) {
      super(controller);
      
      // Create a Swing UI within ExampleView.
  }
}
```

## Credits & Inspiration

* Architecture
    * Robert Eckstein's ["Java SE Application Design With MVC"](https://www.oracle.com/technical-resources/articles/javase/application-design-with-mvc.html).
    * Juri Strumpflohner's ["Logical separation with MVC"](https://juristr.com/blog/2008/03/logical-separation-with-mvc/), a follow-up to Eckstein's article.
* [Filthy Rich Clients: Developing Animated and Graphical Effects for Desktop Java™ Applications](https://www.amazon.ca/Filthy-Rich-Clients-Developing-Applications/dp/0132413930/)