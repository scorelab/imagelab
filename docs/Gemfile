source "https://rubygems.org"

# https://github.com/poole/hyde

#gem 'jekyll-paginate', group: :jekyll_plugins

#Use following command to run the ste with live reloading.
#bundle exec jekyll serve --livereload

# relative_permalinks: false
# group :jekyll_plugins do
#     gem "jekyll-feed", "~> 0.6"
#     gem "jekyll-paginate"
#   end

gem "github-pages", group: :jekyll_plugins
# If you have any plugins, put them here!
group :jekyll_plugins do
  gem "jekyll-feed", "~> 0.12"
  gem "jekyll-paginate"
end

# Windows and JRuby does not include zoneinfo files, so bundle the tzinfo-data gem
# and associated library.
platforms :mingw, :x64_mingw, :mswin, :jruby do
  gem "tzinfo", "~> 1.2"
  gem "tzinfo-data"  
end

# Performance-booster for watching directories on Windows
gem "wdm", "~> 0.1.1", :platforms => [:mingw, :x64_mingw, :mswin]