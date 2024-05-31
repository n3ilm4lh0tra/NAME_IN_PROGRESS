public class Text {
    public Text() {
    }

    /**
     * the instruction manual
     */
    public void instructions() {
        System.out.println("""
                #INSTRICTION
                #-----------------------------
                #to add - add
                #to remove - remove
                #to move - move
                #to resize - resize
                #to list all objects - list
                #to clear the grid - clear
                #to exit - exit
                #
                #WARNING!!!
                #commands are sensitive to spacebar
                #refrain from using it if possible
                #
                #the object is made by expanding into
                 a direction starting from the
                 x and y coordinates
                #there is no stacking of objects
                 thus meaning there is a collision
                 detector
                #collision removes the object in any
                 scenario may it be moving or resizing
                """);
    }

    /**
     * the introduction
     */
    public void intro() {
        System.out.println("""
                #type help for instructions
                """);
    }
}
