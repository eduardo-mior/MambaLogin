package rush.login.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import rush.login.entidades.LPlayer;
import rush.login.utils.Encryption;

public class CommandChangePassword implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
		if (cmd.getName().equalsIgnoreCase("changepassword")) {
			LPlayer lp = LPlayer.get(s.getName());

			if (args.length != 1) {
				s.sendMessage("§cComando incorreto, use /trocarsenha <nova-senha>");
				return false;
			}
			
			if (args[0].length() < 5) {
				s.sendMessage("§cSenha muito curta! A sua senha deve conter no mínimo 5 caracteres.");
				return false;
			}
			
			if (args[0].length() > 25 ) {
				s.sendMessage("§cSenha muito longa! A sua senha deve conter no máximo 25 caracteres.");
				return false;
			}
			
			for (int i = 0; i < args[0].length(); i++) {
				char c = args[0].charAt(i);
				if (c == 'a' || c == 'A' || c == 'b' || c == 'B' ||	c == 'c' || c == 'C' || c == 'd' || c == 'D' ||
					c == 'e' || c == 'E' ||	c == 'f' || c == 'F' ||	c == 'g' || c == 'G' ||	c == 'h' || c == 'H' ||
					c == 'i' || c == 'I' || c == 'j' || c == 'J' ||	c == 'k' || c == 'K' ||	c == 'l' || c == 'L' ||
					c == 'm' || c == 'M' || c == 'n' || c == 'N' ||	c == 'o' || c == 'O' ||	c == 'p' || c == 'P' ||
					c == 'q' || c == 'Q' ||	c == 'r' || c == 'R' ||	c == 's' || c == 'S' ||	c == 't' || c == 'T' ||
					c == 'u' || c == 'U' ||	c == 'v' || c == 'V' ||	c == 'w' || c == 'w' ||	c == 'x' || c == 'X' ||
					c == 'y' || c == 'W' ||	c == 'z' || c == 'Z' ||	c == '0' || c == '1' ||	c == '2' || c == '3' ||
					c == '4' || c == '5' ||	c == '6' || c == '7' ||	c == '8' || c == '9' ||	c == '!' || c == '@' ||
					c == '$' || c == '%' || c == '&' ||	c == '*' || c == '+' ||	c == '-' || c == '_' ||	c == '=' || 
					c == '?' || c == '>' || c == '<' || c == '/' || c == '.' || c == ',' || c == '(' || c == ')' ){
					continue;
				} else {
					s.sendMessage("§cO caractere '" + c + "' não pode ser usado na senha!");
					return false;
				}
			}
			
			String pass = Encryption.encrypt(args[0]);
			if (pass.equals(lp.getSenha())) {
				s.sendMessage("§cSua senha já é '" + args[0] +"'.");
				return false;
			}
			
			s.sendMessage("§aSenha redefinida com sucesso!");
			lp.setSenha(pass);
		}
		return false;
	}
}