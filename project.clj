(defproject clojure-gae-quickstart "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-ring "0.11.0"]]
  :ring {:handler clojure-gae-quickstart.core/app}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.2"]
                 [ring/ring-core "1.5.1"]
                 [ring/ring-servlet "1.5.1"]
                 [cheshire "5.7.0"]
                 ])
