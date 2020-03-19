package bubbleshooter.view.images;

public enum ImagePath {

        /**
         * The image for Player.
         */
        CANNON("resources/view/cannon/cannon.png"),

        /**
         * The image for background.
         */
        BACKGROUND("resources/view/background/background.png"),
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
    
