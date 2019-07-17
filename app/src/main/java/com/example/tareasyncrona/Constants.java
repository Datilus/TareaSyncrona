package com.example.tareasyncrona;

public class Constants {

    public enum Api {
        URL("");

        String IP;

        private Api(String data) {
            this.IP = data;
        }

        public String getIP() {
            return this.IP;
        }

        public void setIP() {
            this.IP = ("http://172.16.1.2:8000");
        }

    }
}
