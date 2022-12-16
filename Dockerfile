FROM golang:1.19-alpine AS builder

WORKDIR /app
COPY go.mod ./
COPY go.sum ./

RUN go mod download

COPY ./ ./

RUN go test -v ./...

RUN go build -o /paperrockscissors


FROM scratch
COPY --from=builder /paperrockscissors /paperrockscissors
CMD [ "/paperrockscissors" ]
