
Installation information
=======

This template repository can be directly cloned to get you started with a new
mod. Simply create a new repository cloned from this one, by following the
instructions provided by [GitHub](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template).

Once you have your clone, simply open the repository in the IDE of your choice. The usual recommendation for an IDE is either IntelliJ IDEA or Eclipse.

### Running and debugging in Zed (Windows)

1. Install JDK 21 and set `JAVA_HOME` to its installation directory. Restart Zed
   after changing environment variables so its terminals pick them up.
2. Open this repository's root folder in Zed and install the **Java** extension.
   Allow its Gradle project import to finish for source navigation and breakpoints.
3. Run **task: spawn** from the command palette and choose **Client**, **Server**,
   **Data**, or **GameTestServer**. **Build Latte** builds the mod jar.

These tasks correspond to the IntelliJ run configurations and use NeoForge's
Gradle run tasks, keeping the working directory, JVM arguments, mod classpath,
and data generation options defined by `build.gradle`.

To debug, set breakpoints and run the corresponding **Debug … (then attach)**
task. Wait for `Listening for transport dt_socket at address: 5005` in the task
terminal, then press **F4** (or run **debugger: start**) and choose
**Attach to Latte (port 5005)**. The game JVM waits for the debugger before
starting, so startup breakpoints work too. Run only one debug task at a time
because they share port 5005. Stop the Gradle task with **Ctrl+C** in its terminal
when finished; disconnecting the debugger may leave the game running.

The Server profile uses `--nogui` and requires accepting Minecraft's EULA in
`run/eula.txt` before it can start. GameTestServer can fail if no game tests are
registered, as noted in `build.gradle`.

If at any point you are missing libraries in your IDE, or you've run into problems you can
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything 
{this does not affect your code} and then start the process again.

Mapping Names:
============
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields 
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/NeoForged/NeoForm/blob/main/Mojang.md

Additional Resources: 
==========
Community Documentation: https://docs.neoforged.net/  
NeoForged Discord: https://discord.neoforged.net/
