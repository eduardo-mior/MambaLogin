package rush.login.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import rush.login.entidades.LPlayer;
import rush.login.entidades.Login;
import rush.login.utils.Encryption;
import rush.login.utils.TitleAPI;

public class CommandLogin extends Login implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
		
		if (!(s instanceof Player)) {
			s.sendMessage("§cO console nao tem permissao para utilizar este comando.");
			return true;
		}
		
		LPlayer lp = LPlayer.get(s.getName());

		if (!lp.isRegistered()) {
			s.sendMessage("§cVocê ainda não esta registrado no servidor.");
			return true;
		}

		Player player = (Player) s;
		if (!BLOCK.contains(player)) {
			s.sendMessage("§cVocê já está logado no servidor.");
			return true;
		}

		if (args.length != 1) {
			s.sendMessage("§cComando incorreto, use /login <senha>");
			return true;
		}

		String bancosenha = lp.getSenha();
		String senhadigitada = Encryption.encrypt(args[0]);

		if (!bancosenha.equals(senhadigitada)) {
			int tentativas = LIST.get(player);

			if (tentativas > 0) {
				s.sendMessage("§cSenha incorreta! Você possui mais " + tentativas + " tentantivas.");
				LIST.replace(player, tentativas - 1);
				return true;
			} else {
				player.kickPlayer("§cVocê excedeu o limite de tentativas de se autenticar.");
				errorLogin(player);
				return true;
			}
		}

		TitleAPI.sendTitle(player, 1, 30, 1, TitleLogado, SubtitleLogado);
		successLogin(player);

		return true;
	}
}