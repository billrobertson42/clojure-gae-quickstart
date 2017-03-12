# clojure-gae-quickstart

This project is an example of the Google App Engine Java hello world
ported to Clojure.

## Usage

1. Install the Google Application Engine Java SDK and clone this repository.
2. Change the application name in `war-resources/WEB-INF/appengine-web.xml`.
3. run `lein ring uberwar`
4. run `make.sh` - this script will explode the war into the `exploded` directory and update the application version in that directory.
5. You can either test the app with `dev_appserver.sh exploded` or deploy it with `appcfg.sh update exploded`.

After updating an application version, you'll need to go and migrate
traffic to the new application version in the GAE Console.

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
