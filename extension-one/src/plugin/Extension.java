package plugin;

import com.google.common.base.Strings;

import runtime.api.Plugin;

public class Extension implements Plugin {

	@Override
	public String getVersion() {
		return Strings.padEnd("1.", 5, '0');
	}

}
