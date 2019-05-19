# Stage 1 - the build process
FROM node:8-alpine as build-deps
WORKDIR app
COPY . ./
RUN yarn
RUN yarn build

# Stage 2 - the production environment
FROM nginx:alpine
COPY --from=build-deps app/build /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]