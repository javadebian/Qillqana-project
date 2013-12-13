package pe.edu.unsaac.in.qillqana.common.gson;

import pe.edu.unsaac.in.qillqana.common.command.Command;

import com.google.gson.Gson;

public class GsonUtils {
	private static Gson gson = new Gson();

	public static String toJson(Command command) {
		return gson.toJson(command);
	}

	public static Command toCommand(String json_string) {
		return gson.fromJson(json_string, Command.class);
	}
}
