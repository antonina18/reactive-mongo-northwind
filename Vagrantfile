Vagrant.configure("2") do |config|
  config.vm.provision "docker" do |d|
    d.pull_images "sovas/northwind-mongo-reactive"
    d.pull_images "mongo"
  end
end