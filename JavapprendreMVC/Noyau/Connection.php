<?php

final class Connection
{

    public PDO $pdo;

    private static ?self $instance = null;
    private const db_server_name = "mysql-javapprendre.alwaysdata.net";
    private const db_username = "302330";
    private const db_password = "javapprendre";
    private const db_name = "javapprendre_db";

    private function __construct()
    {
        $this->pdo = new PDO(
            sprintf('mysql:dbname=%s;host=%s', self::db_name, self::db_server_name),
            self::db_username,
            self::db_password
        );
    }

    public static function getInstance(): self
    {
        if (null === self::$instance) {
            self::$instance = new self();
        }
        return self::$instance;
    }

    public function getPdo()
    {
        return $this->pdo;
    }
    public function insert(string $table, array $parameters): bool
    {
        $attributes = implode(', ', array_keys($parameters));
        $valueKeys = implode(', ', array_map(fn(string $value) => ':' . $value, array_keys($parameters)));
        $query = sprintf('INSERT INTO %s (%s) VALUES (%s)', $table, $attributes, $valueKeys);

        $stmt = $this->pdo->prepare($query);
        foreach ($parameters as $attribute => $value) {
            $stmt->bindParam($attribute, $value);
        }
        $result = $stmt->execute();

        if (false === $result) {
            throw new RuntimeException(sprintf(
                "Cannot insert value for table %s and value %s. SQL error code : %s. SQL error info : %s",
                $table,
                json_encode($parameters),
                $stmt->errorCode(),
                json_encode($stmt->errorInfo())
            ));
        }
        return $result;
    }

    public function delete(string $table, $where)
    {
        $query = "DELETE FROM $table WHERE $where";

        try {
            $stmt = $this->pdo->prepare($query);
            $stmt->execute();
            return true;
        } catch (PDOException $e) {
            die('Error : ' . $e->getMessage());
        }
    }

    public function update(string $table, $data, $where)
    {
        $query = "UPDATE $table SET ";
        $parameters = array();
        foreach ($data as $key => $value) {
            $parameters[] = "$key = :$key";
        }
        $query .= implode(', ', $parameters);
        $query .= " WHERE $where";

        try {
            $stmt = $this->pdo->prepare($query);
            $stmt->execute($data);
            return true;
        } catch (PDOException $e) {
            die('Error : ' . $e->getMessage());
        }
    }
    public function select(string $table, array $conditions = [], string $selectFields = '*'): array
    {
        $query = "SELECT $selectFields FROM $table";

        if (!empty($conditions)) {
            $parameters = [];
            foreach ($conditions as $key => $value) {
                $parameters[] = "$key = :$key";
            }
            $query .= ' WHERE ' . implode(' AND ', $parameters);
        }

        try {
            $stmt = $this->pdo->prepare($query);
            $stmt->execute($conditions);
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            die('Error : ' . $e->getMessage());
        }
    }
}

