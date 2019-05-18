# Stage 1 - the build process
FROM node:8-alpine as build-deps
WORKDIR frontend-app
COPY package.json yarn.lock ./
RUN yarn
COPY . ./
RUN yarn build

# Stage 2 - the production environment
FROM nginx:alpine
COPY --from=build-deps frontend-app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]