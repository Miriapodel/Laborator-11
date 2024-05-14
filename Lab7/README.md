CURS 6

*** Interfete marker

Cloneable (face o copie a clasei), 
Serializable (elementele clasei sunt livrate in ordine -  folosit la scriere in fisere, transmisii)


*** Clase adaptor

Se creaza o clasa intermediara care implementeaza mimim metodele neutilizate ale interfetei.
Va implementa doar metodele utilizate.

Apoi aceasta clasa va fi extinsa.


*** Sealed classes (controlul mostenirii)

sealed -> clasa poate fi extinsa in mod controlat

sealed class A extends B implements Interf1 permits Cls1, Cls2, Cls3{....}

3 variante posibile:

1) contine final si nu mai ofera lista de clase de extins

  final class Cls1 extends A{...}

2) contine sealed si ofera o lista de clase de extins

sealed class Cls1 extends A permits Cls11, Cls12{...}

3) contine non-sealed, adica va putea fi extinsa

non-sealed class Cls1 extends A{...}

*** Enumerari

keyword: enum

public enum Cardinale {
     enumerare de constante;
     variabile private care definesc un element;
     metode
     constructor
}

Un enum poate contine si o metoda abstracta, 
caz in care fiecare instanta trebuie sa faca override si sa defineasca metoda.