(ns clojure-gae-quickstart.core
  (:require [cheshire.core :as json]
            [compojure.core :refer :all]
            [compojure.route :refer [not-found]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.util.response :as ring]))

(defn wrap-welcome [handler welcome]
  (fn [request]
    (let [response (handler request)]
      (if (and (or (nil? response) (= 404 (:status response)))
               (.endsWith (:uri request) "/"))
        (handler (assoc request 
                        :uri (str (:uri request) welcome)
                        :path-info (str (:uri request) welcome)))
        response))))

(defn json-response [body]
  (-> (ring/response (json/generate-string body))
      (ring/content-type "application/json")
      (ring/charset "UTF-8")))

(defn demo[request]
  (json-response {:name "\u4E16\u754C"}))

(defroutes app-routes
  (GET "/demo" [] demo)
  (not-found ""))

(def app
  (-> app-routes      
      (wrap-resource "public")
      (wrap-welcome "index.html")))
