public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        for (int i=0; i<this.letrasJaDigitadas.length(); i++)
        {
            if (letrasJaDigitadas.charAt(i) == letra)
                return true;
        }
        return false;
    }

    public void registre (char letra) throws Exception
    {
        if (this.isJaDigitada(letra))
            throw new Exception("Letra já digitada");
        
        this.letrasJaDigitadas += letra;
    }

    @Override
    public String toString ()
    {
        String todasLetrasDigitadas = "";
        
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++)
        {
            if (i < this.letrasJaDigitadas.length() - 1)
                todasLetrasDigitadas += (this.letrasJaDigitadas.charAt(i) + ",");
            else
                todasLetrasDigitadas += this.letrasJaDigitadas.charAt(i);
        }

        return todasLetrasDigitadas;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj.getClass() == this.getClass())) return false;

        ControladorDeLetrasJaDigitadas c = (ControladorDeLetrasJaDigitadas) obj;
        for (int i=0; i<this.letrasJaDigitadas.length(); i++)
        {
            if (c.letrasJaDigitadas.charAt(i) != this.letrasJaDigitadas.charAt(i))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;
        ret = ret * 2 + letrasJaDigitadas.hashCode();
        
        if (ret < 0) ret = -ret;

        return ret;
    }

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception // construtor de c�pia
    {
        if (controladorDeLetrasJaDigitadas == null) throw new Exception("Modelo ausente");

        this.letrasJaDigitadas = new String (controladorDeLetrasJaDigitadas.letrasJaDigitadas);
    }

    public Object clone ()
    {
        ControladorDeLetrasJaDigitadas c = null;
        try
        {
            c = new ControladorDeLetrasJaDigitadas(this);
        }
        catch (Exception erro)
        {}  // sei que não vai dar erro

        return c;
    }
}
