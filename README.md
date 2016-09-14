# am2_group2016_2

Ejercicio sobre uso de Callbacks para la comunidaciòn entre fragments

  <img src="https://github.com/ISILAndroid/am2_group2016_2/blob/Practice01/SampleColors.png" height="300">
  
  Este ejercicio se refiere a poder seleccionar un color de la barra inferior y  pintar en la parte superior el color correspondiente.
  
  1. Para esto vamos a crear un actividad llamada ColorActivity, este nos va a servir de contenedor para los Fragments
  2. Luego vamos a necesitar crear 2 fragments , FooterFragment que contiene los botones con colores y BoxFragment que es un caja donde pintaremos el color elegido.
  3. Para poner tener esa distribuciòn (diseño) necesitamos modificar el XMl de ColorActivity, utilizar un layout tipo LinearLayout y jugar con los pesos en vertical. En este caso la proporciòn serìa de 8/2 o 7/3 , donde la parte superior tendria el mayor peso. En nuestro contenedor (LinearLayout) vamos a agregar los 2 fragment, BoxFragment primero y luego FooterFragment.
  4. Lo siguiente serìa definir un calback para poder "pasar" el color seleccionado de un Fragment a otro. Esto lo hacemos creando un interfaz llamada "OnColorListener" y creamos un mètodo llamado "seleccionarColor(color)" donde recibe como paràmetro el botòn seleccionado, es decir El primer botòn es 0, el siguiente 1, etc etc 
  5. Para poder asociar este callback a los fragment necesitamos "agregarlo" al còdigo en cada uno de ellos . Los mètodos son "onAtach" y "onDetach"
  6. xxxx

  
  
  
