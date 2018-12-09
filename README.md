# MongoDB

```
docker run --name mongodb -d \
  -e MONGODB_USERNAME=root \
  -e MONGODB_PASSWORD=password123 \
  -e MONGODB_DATABASE=lightning \
  -p 27017:27017 bitnami/mongodb:latest
```