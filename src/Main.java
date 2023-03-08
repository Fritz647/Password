public class Main {
    public static void main(String[] args) {
        System.out.println(Main.check("Zavrazhnov", "RuxEW67", "RuxEW67"));
    }
    public static boolean check(String login, String pasowrd, String confirmPassword){
        String[] symbols = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z", "_"};
        String[] worngSymbols = {"!", "@", "№", "#", ";", "$", "%", ":", "^", "?", "&", "(", ")", "-", "=", "+", ".", ",", "/", ">", "<", "|",
                "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш",
                "Щ", "Э", "Ю", "Я", "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х",
                "ц", "ч", "ш", "щ", "э", "ю", "я"};
        int l = 0;
        int p = 0;
        try{
            for (String symbols1:symbols){
                if(login.contains(symbols1))
                    l+=1;
                if(pasowrd.contains(symbols1))
                    p+=1;
            }
            for (String worngSymbols1:worngSymbols){
                if(login.contains(worngSymbols1))
                    throw new WrongLoginException("Недопустимые символы");
                if(pasowrd.contains(worngSymbols1))
                    throw new WrongPasswordException("Недопустимые символы");
            }
            if (l==0)
                throw new WrongLoginException();
            if (p==0)
                throw new  WrongPasswordException();
            if (login.length()>20)
                throw new WrongLoginException("Сликшком длинный логин");
            if (pasowrd.length()>20)
                throw new WrongPasswordException("Слишком длинный пароль");
            if(!pasowrd.equals(confirmPassword))
                throw new WrongPasswordException("Пароли не совпадают");

        }
        catch (WrongLoginException | WrongPasswordException a){
            System.out.println(a);
            return false;
        }
        System.out.println("Пароль и логин введены верно");
        return true;
    }
}