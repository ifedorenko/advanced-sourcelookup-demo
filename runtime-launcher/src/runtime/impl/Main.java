package runtime.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import runtime.api.Plugin;

@SuppressWarnings({ "unchecked", "resource", "deprecation" })
public class Main {
	public static void main(String[] args) throws IOException, ReflectiveOperationException {
		String basedir = new File(".").getCanonicalFile().getParentFile().toURL().toExternalForm();
		Plugin[] extensions = new Plugin[] { //
				loadExtension(basedir + "extension-two"), //
				loadExtension(basedir + "extension-one") //
		};
		for (Plugin extension : extensions) {
			System.out.println(extension.getVersion());
		}
	}

	private static Plugin loadExtension(String basedir) throws IOException, ReflectiveOperationException {
		URL[] cp = new URL[] { new URL(basedir + "/bin/"), new URL(basedir + "/lib/guava.jar") };
		URLClassLoader cl = new URLClassLoader(cp, Main.class.getClassLoader());
		Class<Plugin> c = (Class<Plugin>) cl.loadClass("plugin.Extension");
		return c.newInstance();
	}
}
