[![Java CI with Maven](https://github.com/Valkryst/VMVC/actions/workflows/maven.yml/badge.svg)](https://github.com/Valkryst/VMVC/actions/workflows/maven.yml)
[![CodeQL](https://github.com/Valkryst/VMVC/actions/workflows/codeql.yml/badge.svg)](https://github.com/Valkryst/VMVC/actions/workflows/codeql.yml)

This project is a Java implementation of the MVC design pattern. It is designed to be used with Swing UIs and for my
personal use. It is not intended to be a general purpose MVC framework, but you are free to use it as such if you wish.
The design goals are as follows:

1. Separate the _View_ from the _Model_. This not only makes the code cleaner, easier to read and maintain, but it also
    allows for easier testing of "business" logic in the _Model_ by having it separate from the UI.
2. Separate some of the Listener logic from the _View_ to the _Controller_. This allows for easier testing, without the
   need for something to click through a UI to trigger a Listener.
3. Provide methods to perform get, set, or compound operations on the _Model_ VIA the _Controller_. Again, this allows
   for cleaner code in the _View_ and less methods in the _Model_.

The classes can be described as follows:

* `Model` - Contains data and "business" logic for manipulating the data. It has no knowledge of the _View_ or _Controller_.
* `View` - A Swing UI. It has no knowledge of the _Model_ and can only get/set data VIA the _Controller_.
* `Controller` - Provides methods for getting/setting data in its _Model_. It may also implement various Listener
  interfaces (e.g. `ActionListener`, `ChangeListener`, etc.) if it needs to communicate with the _Model_ when the
  _View_ changes.

## Links

* [Example](https://github.com/Valkryst/VMVC#example)
  * [Controller](https://github.com/Valkryst/VMVC#controller)
  * [Model](https://github.com/Valkryst/VMVC#model)
  * [View](https://github.com/Valkryst/VMVC#view)
* [Credits & Inspiration](https://github.com/Valkryst/VMVC#credits--inspiration)

## Example

Using the _Controller_, _Model_, and _View_ classes below, we can display the _View_ in a Swing UI as follows:

```java
import javax.swing.*;
import java.awt.*;

public class Example {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> {
            final var frame = new JFrame("Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(640, 480));
            
            // createView() will call the overridden methods in ExampleModel.
            frame.add(new ExampleModel().createView());
            
            frame.setVisible(true);
            frame.pack();
            frame.setLocationRelativeTo(null);
        });
    }
}
```



### Controller

```java
// This can implement various Listener interfaces, if the View requires it.
public class ExampleController extends Controller<ExampleModel> {
    public ExampleController(final ExampleModel model) {
        super(model);
    }
    
    // Add methods to perform get, set, or compound actions on the Model.
  
    // Add overridden methods from Listener interfaces, if the View requires it.
}
```

### Model

```java
public class ExampleModel extends Model<ExampleController, ExampleView> {
    // Add instance variables to store data used by the View.
    
    @Override
    protected ExampleController createController() {
      return new ExampleController(this);
    }
  
    @Override
    protected ExampleView createView(final ExampleController controller) {
      return new ExampleView(controller);
    }
    
    // Add methods to perform "business" logic on the data.
}
```

### View

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