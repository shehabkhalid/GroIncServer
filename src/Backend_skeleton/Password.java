package Backend_skeleton;

public class Password
  {

    private static StringBuilder pass;
    private static char[] reference =
      {
        'あ', 'せ', 'む', '½', 'º', '¼', '•', '¾', '»', '✂', 'れ', 'い', '✏', 'に',
        'ろ', '✌', 'す', '⌘', '♋', 'へ', '॔', '☃', 'O', '╠', 'を', 'ま', 'て', 'き', 'う', 'え', 'け', 'お', 'ぬ', '☮', '❀', '☥', '✾', '❄', '☢',
        'Ѡ', '➀', '∂', '♨', '✈', '☣', '☠', 'ｯ', '☯', '♫', '↫', '➉', '⇔', 'Ψ', '¤', '☒', '☭', '♐', '☄', '☂', 'Ö', 'π', 'Ω'
      };

    public static String Encrypt(StringBuilder pass)
      {
        for (int i = 0; i < pass.length(); i++)
          {
            int index;
            if (pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z')
              {
                index = ((pass.charAt(i) - 'G') + pass.length()) % reference.length;
                pass.setCharAt(i, reference[index]);
              } else if (pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z')
              {
                index = ((pass.charAt(i) - 'A') + pass.length()) % reference.length;
                pass.setCharAt(i, reference[index]);
              } else if (Character.isDigit(pass.charAt(i)))
              {
                index = ((Character.getNumericValue(pass.charAt(i)) + 52) + pass.length()) % reference.length;
                pass.setCharAt(i, reference[index]);
              } else
              {
                index = pass.charAt(i) + pass.length();
                pass.setCharAt(i, (char) index);
              }
          }
        return pass.toString();
      }

    public static String Decrypt(StringBuilder DecryptedPass)
      {
        StringBuilder decryptPass = DecryptedPass;
        int index;
        boolean isSet;
        for (int i = 0; i < DecryptedPass.length(); i++)
          {
            isSet = false;
            for (int j = 0; j < reference.length; j++)
              {
                if (DecryptedPass.charAt(i) == reference[j])
                  {
                    isSet = true;
                    index = j - DecryptedPass.length();
                    if (j - DecryptedPass.length() < 0)
                      {
                        index += (reference.length);
                      }
                    if (index <= 25)
                      {
                        decryptPass.setCharAt(i, (char) ('A' + index));
                      } else if (index <= 51)
                      {
                        decryptPass.setCharAt(i, (char) ('G' + index));
                      } else if (index <= 61)
                      {
                        decryptPass.setCharAt(i, (char) ('0' + (index - 52)));
                      }
                    break;
                  }
              }
            if (!isSet)
              {
                index = DecryptedPass.charAt(i) - DecryptedPass.length();
                decryptPass.setCharAt(i, (char) (index));
              }
          }
        return (decryptPass.toString());
      }
    
    public static boolean  isValid(String a)
      {
        return (a.length()>=8)?true:false;
      }

  }
