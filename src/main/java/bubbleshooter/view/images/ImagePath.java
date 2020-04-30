package bubbleshooter.view.images;

public enum ImagePath {
        /**
         * Ball color blue.
         */
        BLUE_BUBBLE("/view/bubbles/blue.png"),
        /**
         * Ball color lightblue.
         */
        LIGHT_BLUE_BUBBLE("/view/bubbles/lightBlue.png"),
        /**
         * Ball color red.
         */
        RED_BUBBLE("/view/bubbles/red.png"),
        /**
         * Ball color green.
         */
        GREEN_BUBBLE("/view/bubbles/green.png"),
        /**
         * Ball color yellow.
         */
        YELLOW_BUBBLE("/view/bubbles/yellow.png"),
        /**
         * Ball color purple.
         */
        PURPLE_BUBBLE("/view/bubbles/purple.png"),
    
        /**
         * The image for Player.
         */
        CANNON("/view/cannon/cannon.png"),

        /**
         * The image for background.
         */
        BACKGROUND("/view/background/background.png"),
        /**
         * The image for explosion.
         */
        ARROW("/view/arrow/arrow.png");

        private final String path;

        ImagePath(final String path) {
            this.path = path;
        }

        /**
         * 
         * @return the path of the image.
         */
        public String getPath() {
            return this.path;
        }
}

