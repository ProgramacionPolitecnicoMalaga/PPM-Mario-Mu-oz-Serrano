public class ProgramaPublicaciones {

    public static void main(String[] args) {

        Publicacion[] publicaciones = new Publicacion[6];


        publicaciones[0] = new Revistas(41, "Hobby Consolas", 2017, 40);
        publicaciones[1] = new Revistas(321, "PC MAX", 2012, 50);
        publicaciones[2] = new Revistas(850, "Hola", 2019, 35);
        publicaciones[3] = new Libros(422, "Harry Potter", 1995);
        publicaciones[4] = new Libros(318, "Juego de Tronos", 1990);
        publicaciones[5] = new Libros(50, "El Nombre del Viento", 2010);

        publicaciones[0].prestar(true);
        publicaciones[2].prestar(true);
        publicaciones[3].prestar(true);
        publicaciones[2].devolver(true);
        publicaciones[5].prestar(true);

        for (int i=0;i<publicaciones.length;i++){
            System.out.println(publicaciones[i]);
        }
    }
}
