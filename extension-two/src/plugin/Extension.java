package plugin;

import com.google.common.base.Strings;

import runtime.api.Plugin;

public class Extension implements Plugin {

	// this extension comes with comments!

	@Override
	public String getVersion() {
		return Strings.padEnd("2.", 5, '0');
	}

}
