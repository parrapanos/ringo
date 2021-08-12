
(ns ringo.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.util.response :refer [resource-response]]
            )
  (:gen-class))

(def hand (resource-response "public/index.html" {:root "public"}))

(def app
  (-> hand
      (wrap-resource "public"))) ;; files from resources/public are served



(defn server []
  (run-jetty app {:join? false, :port 3000}))

(defn -main [& args]
  (server))
