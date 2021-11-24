(ns withnamespaces.core
    (:require [clojure.java.browse :as browse]
              [withnamespaces.svg :refer [xml]])
    (:gen-class))

(def heists [{:locations "Joinvill, SC"
              :cheese-name "Teste",
              :lat 50.95,
              :lng 6.97}
             {:locations "Floripa, SC"
              :cheese-name "Teste",
              :lat 47.37,
              :lng 8.55}
             {:locations "Garopaba, SC"
              :cheese-name "Teste",
              :lat 43.30,
              :lng 5.37}
             {:locations "Laguna, SC"
              :cheese-name "Teste",
              :lat 47.37,
              :lng 8.55}
             {:locations "Porto Alegre, RS"
              :cheese-name "Teste",
              :lat 41.90,
              :lng 12.45}])

(defn url
    [filename]
    (str "file:///"
        (System/getProperty "user.dir")
        "/"
        filename))

(defn template
    [contents]
    (str "<style> polyline{ fill:none; stroke:#5881d8; stroke-width: 3} </style>"
        contents))
        
(defn -main
    [& args]
    (let [filename "map.html"]
        (->> heists
            (xml 50 100)
            template
            (spit filename))
        (browse/browse-url (url filename))))
