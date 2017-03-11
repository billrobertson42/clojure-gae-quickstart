(ns clojure-gae-quickstart.core
  (:require [cheshire.core :as json]
            [compojure.core :refer :all]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.util.response :as ring]))

(defn hello-response[request]
  (->
   {:body (json/generate-string {:name "\u4E16\u754C"})}
   (ring/content-type "application/json")
   (ring/charset "UTF-8")))   

(defroutes app-routes
  (GET "/demo" [] hello-response)
  (GET "/" [] (ring/redirect "/index.html")))

(def app
  (-> app-routes
      (wrap-resource "public")))
